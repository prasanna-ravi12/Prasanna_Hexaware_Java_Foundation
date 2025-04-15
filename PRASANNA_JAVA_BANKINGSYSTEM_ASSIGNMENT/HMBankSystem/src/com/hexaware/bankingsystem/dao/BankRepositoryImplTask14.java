package com.hexaware.bankingsystem.dao;

import com.hexaware.bankingsystem.entity.*; import com.hexaware.bankingsystem.util.DBUtil;

import java.sql.*; import java.util.ArrayList; import java.util.List;

public class BankRepositoryImplTask14 implements IBankRepositoryTask14 {


@Override
public boolean createAccount(CustomerTask14 customer, long accNo, String accType, double balance) {
    try (Connection conn = DBUtil.getDBConn()) {
        conn.setAutoCommit(false);

        String insertCustomer = "INSERT INTO Customers (first_name, last_name, DOB, email, phone_number, address) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps1 = conn.prepareStatement(insertCustomer, Statement.RETURN_GENERATED_KEYS);
        ps1.setString(1, customer.getFirstName());
        ps1.setString(2, customer.getLastName());
        ps1.setDate(3, customer.getDob());
        ps1.setString(4, customer.getEmail());
        ps1.setString(5, customer.getPhoneNumber());
        ps1.setString(6, customer.getAddress());
        ps1.executeUpdate();

        ResultSet rs = ps1.getGeneratedKeys();
        int customerId = 0;
        if (rs.next()) {
            customerId = rs.getInt(1);
        }

        String insertAccount = "INSERT INTO Accounts (customer_id, account_type, balance) VALUES (?, ?, ?)";
        PreparedStatement ps2 = conn.prepareStatement(insertAccount);
        ps2.setInt(1, customerId);
        ps2.setString(2, accType);
        ps2.setDouble(3, balance);
        ps2.executeUpdate();

        conn.commit();
        return true;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

@Override
public List<AccountTask14> listAccounts() {
    List<AccountTask14> list = new ArrayList<>();
    try (Connection conn = DBUtil.getDBConn();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM Accounts")) {
        while (rs.next()) {
            list.add(new AccountTask14(
                    rs.getInt("account_id"),
                    rs.getInt("customer_id"),
                    rs.getString("account_type"),
                    rs.getDouble("balance")));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}

@Override
public AccountTask14 getAccountDetails(long accountNumber) {
    try (Connection conn = DBUtil.getDBConn();
         PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts WHERE account_id = ?")) {
        ps.setLong(1, accountNumber);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new AccountTask14(
                    rs.getInt("account_id"),
                    rs.getInt("customer_id"),
                    rs.getString("account_type"),
                    rs.getDouble("balance"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

@Override
public double getAccountBalance(long accountNumber) {
    AccountTask14 acc = getAccountDetails(accountNumber);
    return acc != null ? acc.getBalance() : -1;
}

@Override
public double deposit(long accountNumber, double amount) {
    try (Connection conn = DBUtil.getDBConn()) {
        AccountTask14 acc = getAccountDetails(accountNumber);
        if (acc == null) return -1;
        double newBalance = acc.getBalance() + amount;

        PreparedStatement ps = conn.prepareStatement("UPDATE Accounts SET balance = ? WHERE account_id = ?");
        ps.setDouble(1, newBalance);
        ps.setLong(2, accountNumber);
        ps.executeUpdate();

        recordTransaction(conn, accountNumber, "deposit", amount);
        return newBalance;
    } catch (Exception e) {
        e.printStackTrace();
        return -1;
    }
}

@Override
public double withdraw(long accountNumber, double amount) {
    try (Connection conn = DBUtil.getDBConn()) {
        AccountTask14 acc = getAccountDetails(accountNumber);
        if (acc == null) return -1;

        double availableBalance = acc.getBalance();
        boolean isCurrent = acc.getAccountType().equalsIgnoreCase("current");
        boolean isSavings = acc.getAccountType().equalsIgnoreCase("savings");

        if (isSavings && availableBalance - amount < 500) return -1;
        if (isCurrent && (availableBalance + 1000 < amount)) return -1;

        double newBalance = availableBalance - amount;

        PreparedStatement ps = conn.prepareStatement("UPDATE Accounts SET balance = ? WHERE account_id = ?");
        ps.setDouble(1, newBalance);
        ps.setLong(2, accountNumber);
        ps.executeUpdate();

        recordTransaction(conn, accountNumber, "withdrawal", amount);
        return newBalance;

    } catch (Exception e) {
        e.printStackTrace();
        return -1;
    }
}

@Override
public boolean transfer(long fromAccountNumber, long toAccountNumber, double amount) {
    try (Connection conn = DBUtil.getDBConn()) {
        conn.setAutoCommit(false);

        double withdrawResult = withdraw(fromAccountNumber, amount);
        if (withdrawResult == -1) return false;

        double depositResult = deposit(toAccountNumber, amount);
        if (depositResult == -1) {
            conn.rollback();
            return false;
        }

        conn.commit();
        return true;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

private void recordTransaction(Connection conn, long accNo, String type, double amount) throws SQLException {
    PreparedStatement ps = conn.prepareStatement(
        "INSERT INTO Transactions (account_id, transaction_type, amount) VALUES (?, ?, ?)");
    ps.setLong(1, accNo);
    ps.setString(2, type);
    ps.setDouble(3, amount);
    ps.executeUpdate();
}

//@Override
//public void calculateInterest() {
//    try (Connection conn = DBUtil.getDBConn();
//         PreparedStatement ps = conn.prepareStatement("UPDATE Accounts SET balance = balance + (balance * 0.045) WHERE account_type = 'savings'")) {
//        ps.executeUpdate();
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}

@Override
public void calculateInterest() {
String sql = "UPDATE Accounts SET balance = balance + (balance * 0.045) WHERE account_type = 'savings'";
try (Connection conn = DBUtil.getDBConn();
PreparedStatement ps = conn.prepareStatement(sql)) {

    int rowsUpdated = ps.executeUpdate();  

    if (rowsUpdated > 0) {  
        System.out.println("✅ Interest added for " + rowsUpdated + " savings account(s).");  
    } else {  
        System.out.println("ℹ️ No savings accounts found for interest calculation.");  
    }  
} catch (SQLException e) {  
    System.out.println("❌ Error while calculating interest: " + e.getMessage());  
    e.printStackTrace();  
}  
}

@Override
public List<TransactionTask14> getTransactions(long accountNumber, Date fromDate, Date toDate) {
    List<TransactionTask14> transactions = new ArrayList<>();
    try (Connection conn = DBUtil.getDBConn();
         PreparedStatement ps = conn.prepareStatement("SELECT * FROM Transactions WHERE account_id = ? AND transaction_date BETWEEN ? AND ?")) {
        ps.setLong(1, accountNumber);
        ps.setDate(2, fromDate);
        ps.setDate(3, toDate);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            transactions.add(new TransactionTask14(
                    rs.getInt("transaction_id"),
                    rs.getInt("account_id"),
                    rs.getString("transaction_type"),
                    rs.getDouble("amount"),
                    rs.getTimestamp("transaction_date")));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return transactions;
}
}
package CEMS.src.application;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ClubExpenditure")// annotation of table in MySQL

public class Expenditure {
    public static int COUNT_FOR_IDS;

    @Id
    @Column(name = "expenditure_id")
    private int expenditureID;
    @Column(name = "description_")
    private String description;
    @Column(name = "account_holder")
    private String accountHolder;
    @Column(name = "payment_account")
    private String paymentAccount;
    @Column(name = "amount")
    private double amount;
    @Column(name = "tax_amount")
    private double taxAmount;
    @Column(name = "total")
    private double total;
    @Column(name = "province")
    private Province province;
    @Column(name = "date_")
    private LocalDate date;
    @Column(name = "vendor_name")
    private Vendor vendorName;
    @Column(name = "category")
    private ExpenditureCategory category;
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;
    @ManyToOne
    private Club club;  // many to one relationship, expenditure to clubs
    @ManyToOne
    private ClubEvent clubEvent;

    public Expenditure() {
    }

    public Expenditure(String description, String accountHolder, String paymentAccount, double amount, double taxAmount,
                       double total, Province province, LocalDate date, Vendor vendorName, ExpenditureCategory category,
                       PaymentMethod paymentMethod, Club club, ClubEvent clubEvent) {
        this.expenditureID = ++COUNT_FOR_IDS;

        this.description = description;
        this.accountHolder = accountHolder;
        this.paymentAccount = paymentAccount;
        this.amount = amount;
        this.taxAmount = taxAmount;
        this.total = total;
        this.province = province;
        this.date = date;
        this.vendorName = vendorName;
        this.category = category;
        this.paymentMethod = paymentMethod;
        this.club = club;
        this.clubEvent = clubEvent;//can be null
    }

    public static int getCountForIds() {
        return COUNT_FOR_IDS;
    }

    public static void setCountForIds(int countForIds) {
        COUNT_FOR_IDS = countForIds;
    }

    public int getExpenditureID() {
        return expenditureID;
    }

    public void setExpenditureID(int expenditureID) {
        this.expenditureID = expenditureID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) { this.amount = amount; }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) { this.taxAmount = taxAmount; }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Vendor getVendorName() {
        return vendorName;
    }

    public void setVendorName(Vendor vendorName) {
        this.vendorName = vendorName;
    }

    public ExpenditureCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenditureCategory category) {
        this.category = category;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ClubEvent getEvent() {
        return clubEvent;
    }

    public void setEvent(ClubEvent clubEvent) {
        this.clubEvent = clubEvent;
    }

    @Override
    public String toString() {
        return
                "Description: \t" + description +
                        "\nAmount: \t" + String.format("%.2f", amount) +
                        "\nTax Amount: \t" + String.format("%.2f", taxAmount) +
                        "\nProvince: \t" + province +
                        "\nTotal: \t\t" + String.format("%.2f", total) +
                        "\nDate: \t\t" + date +
                        "\nCategory: \t" + category +
                        "\nVendor Name: \t" + vendorName +
                        "\nPayment Method: " + paymentMethod +
                        "\nAccount Holder: " + accountHolder +
                        "\nPayment Account: " + paymentAccount;
    }

    public Integer maxIExpendutureID() {
        Integer result = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select max(e.expenditureID) from Expenditure e");
            result = (int) query.getResultList().get(0);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return result;
    }

}

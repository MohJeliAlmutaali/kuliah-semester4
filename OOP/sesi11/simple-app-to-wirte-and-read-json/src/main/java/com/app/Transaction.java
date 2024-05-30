package com.app;

import java.util.Date;

public class Transaction {
    private int idTransaction;
    private Date dateTransaction;
    private int idmember;
    private int idBook;
    private int status;

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public int getIdmember() {
        return idmember;
    }

    public void setIdmember(int idmember) {
        this.idmember = idmember;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "idTransaction=" + idTransaction +
                ", dateTransaction=" + dateTransaction +
                ", idmember=" + idmember +
                ", idBook=" + idBook +
                ", status=" + status +
                '}';
    }
}
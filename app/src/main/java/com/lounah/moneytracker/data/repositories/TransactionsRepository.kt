package com.lounah.moneytracker.data.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.lounah.moneytracker.data.datasource.local.TransactionsDao
import com.lounah.moneytracker.data.entities.Currency
import com.lounah.moneytracker.data.entities.Transaction
import com.lounah.moneytracker.data.entities.TransactionType
import com.lounah.moneytracker.data.entities.WalletType
import java.util.*
import javax.inject.Inject

class TransactionsRepository @Inject constructor(private val dao: TransactionsDao) {

    fun addTransaction(transaction: Transaction) {
        //dao.insert(transaction)
    }

    fun addTransactions(transactions: List<Transaction>) {
        dao.insertAll(transactions)
    }

    fun getAllTransactions() : LiveData<List<Transaction>> {
        val result = MutableLiveData<List<Transaction>>()
        result.value = listOf(Transaction(0, Date(), WalletType.CASH, "Инструменты", TransactionType.HOME, 164.00, Currency.RUB),
                Transaction(1, Date(), WalletType.CASH,"Запчасти", TransactionType.AUTO, -1644.00, Currency.RUB),
                Transaction(2, Date(), WalletType.BANK_ACCOUNT,"ЖКХ", TransactionType.COMMUNAL_PAYMENTS, 11564.00, Currency.RUB),
                Transaction(3, Date(), WalletType.CREDIT_CARD,"Носки", TransactionType.CLOTHES, -104.00, Currency.RUB),
                Transaction(4, Date(), WalletType.CREDIT_CARD,"Курсы", TransactionType.EDUCATION, -1632.00, Currency.RUB),
                Transaction(5, Date(), WalletType.BANK_ACCOUNT,"Табрис", TransactionType.FOOD, -1632.00, Currency.RUB),
                Transaction(6, Date(), WalletType.CASH,"Игрушки", TransactionType.FAMILY, -1632.00, Currency.RUB),
                Transaction(7, Date(), WalletType.CASH,"Кафе", TransactionType.REST, -1632.00, Currency.RUB),
                Transaction(8, Date(), WalletType.CASH,"Лекарства", TransactionType.TREATMENT, -1632.00, Currency.RUB),
                Transaction(9, Date(), WalletType.CASH,"Запчасти", TransactionType.AUTO, -1423.00, Currency.RUB))
        return result
    }

    fun getAllIncomeTransactions(): LiveData<List<Transaction>> {
        val result = MutableLiveData<List<Transaction>>()
        result.value = listOf(Transaction(0, Date(), WalletType.CASH, "Инструменты", TransactionType.HOME, 164.00, Currency.RUB),
                Transaction(2, Date(), WalletType.BANK_ACCOUNT,"ЖКХ", TransactionType.COMMUNAL_PAYMENTS, 11564.00, Currency.RUB),
                Transaction(4, Date(), WalletType.CREDIT_CARD,"Курсы", TransactionType.EDUCATION, 1632.00, Currency.RUB),
                Transaction(5, Date(), WalletType.BANK_ACCOUNT,"Табрис", TransactionType.FOOD, 432.00, Currency.RUB))
        return result
    }

    fun getAllExpenseTransactions(): LiveData<List<Transaction>> {
        val result = MutableLiveData<List<Transaction>>()
        result.value = listOf(
                Transaction(4, Date(), WalletType.CREDIT_CARD,"Курсы", TransactionType.EDUCATION, -1632.00, Currency.RUB),
                Transaction(5, Date(), WalletType.BANK_ACCOUNT,"Табрис", TransactionType.FOOD, -1632.00, Currency.RUB),
                Transaction(6, Date(), WalletType.CASH,"Игрушки", TransactionType.FAMILY, -1632.00, Currency.RUB),
                Transaction(7, Date(), WalletType.CASH,"Кафе", TransactionType.REST, -1632.00, Currency.RUB),
                Transaction(8, Date(), WalletType.CASH,"Лекарства", TransactionType.TREATMENT, -1632.00, Currency.RUB),
                Transaction(9, Date(), WalletType.CASH,"Запчасти", TransactionType.AUTO, -1423.00, Currency.RUB))
        return result
    }

    fun getAllTransactionsByWallet(wallet: WalletType)
        = dao.getAllTransactionsByWallet(wallet)

    fun getIncomeTransactionsByWallet(wallet: WalletType)
        = dao.getIncomeTransactionsByWallet(wallet)

    fun getExpenseTransactionsByWallet(wallet: WalletType)
        = dao.getExpenseTransactionsByWallet(wallet)

    fun deleteTransaction(transaction: Transaction) {
        dao.delete(transaction)
    }

    fun updateTransaction(transaction: Transaction) {
        dao.update(transaction)
    }
}
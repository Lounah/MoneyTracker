package com.lounah.moneytracker.data.datasource.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.lounah.moneytracker.data.entities.Wallet
import com.lounah.moneytracker.data.entities.WalletType


@Dao
interface WalletDao : BaseDao<Wallet> {
    @Query("SELECT * FROM wallets")
    fun getAllWallets(): LiveData<List<Wallet>>

    @Query("SELECT * FROM wallets WHERE balanceType=:type")
    fun getWalletByType(type: WalletType): LiveData<Wallet>
}
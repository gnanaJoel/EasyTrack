package com.tri_devs.easytrack.entities

import android.os.Parcel
import android.os.Parcelable


data class Product(
    var name: String?,
    var description: String?,
    var quantity: Int,
    var upcNumber: Long,
    var retailPrice: String?,
    var salesPrice: String?,
    var startSalesDate: String?,
    var endSalesDate: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(quantity)
        parcel.writeLong(upcNumber)
        parcel.writeString(retailPrice)
        parcel.writeString(salesPrice)
        parcel.writeString(startSalesDate)
        parcel.writeString(endSalesDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}

package com.maclaurin.footballclub

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Club (val name: String?, val image: Int, val info: String?) : Parcelable
package com.android.negaraasean

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Asean(
    val name: String,
    val description: String,
    val photo: Int
): Parcelable

package com.example.simplelist.model

import java.io.Serializable

data class Contact(
    val name: String,
    val phone: Long,
    val description: String,
    val image: Int

): Serializable
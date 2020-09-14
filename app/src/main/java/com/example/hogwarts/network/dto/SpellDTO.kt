package com.example.hogwarts.network.dto

import com.example.hogwarts.utils.BaseViewHolderModel

data class SpellDTO(
    val _id: String?,
    val spell: String?,
    val type: String?,
    val effect: String?
) : BaseViewHolderModel<SpellDTO>()
package com.data

data class Pokemon (
        val id: Int,
        val name: String,
        val type1: String,
        val type2: String,
        val total: Int,
        val hp: Int,
        val attack: Int,
        val defence: Int,
        val spAttack: Int,
        val spDefence: Int,
        val speed: Int,
        val generation: Int,
        val legendary: Boolean
)

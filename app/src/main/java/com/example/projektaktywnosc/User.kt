package com.example.projektaktywnosc

class User(val id: String = "",
           val email: String = "",
           val wiek1: String="",
            val wzrost1: String="",
           var idealnawaga: String="",
            var wagaaktualna: List<String> = listOf<String>(),
           var progreswoda:List<String> = listOf<String>(),
           var progresen:List<String> = listOf<String>()
)
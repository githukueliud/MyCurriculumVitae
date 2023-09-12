package com.example.mycurriculumvitae.model

import com.example.mycurriculumvitae.R

class HobbiesList() {
    fun loadHobbies(): List<HobbiesInfo> {
        return listOf<HobbiesInfo>(
            HobbiesInfo(R.string.reading_books),
            HobbiesInfo(R.string.playing_field_hockey),
            HobbiesInfo(R.string.attending_tech_meetups)
        )
    }
}

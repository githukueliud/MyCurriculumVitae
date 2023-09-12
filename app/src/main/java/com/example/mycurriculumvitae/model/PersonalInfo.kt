package com.example.mycurriculumvitae.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PersonalInfo(
    @DrawableRes val personalImage: Int,
    @StringRes val name: Int,
    @StringRes val phoneNumber: Int,
    @StringRes val email: Int,
)

data class SummaryInfo(
    @StringRes val summaryTitle: Int,
    @StringRes val summaryText: Int
)

data class SkillList(
    @StringRes val skill: Int
)

data class ExperienceTaskList(
    @StringRes val experienceTask: Int
)

data class HobbiesInfo(
    @StringRes val hobby: Int
)






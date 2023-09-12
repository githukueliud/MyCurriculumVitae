package com.example.mycurriculumvitae.model

import com.example.mycurriculumvitae.R

class SkillsList {
    fun loadSkills(): List<SkillList> {
        return listOf<SkillList>(
            SkillList(R.string.test_driven_development_skill),
            SkillList(R.string.building_robust_apps),
            SkillList(R.string.consuming_rest_apis),
            SkillList(R.string.building_beautiful_uis),
            SkillList(R.string.integrating_room_for_database),
            SkillList(R.string.collaboration_with_team_members),
            SkillList(R.string.eager_to_learn)
        )
    }
}
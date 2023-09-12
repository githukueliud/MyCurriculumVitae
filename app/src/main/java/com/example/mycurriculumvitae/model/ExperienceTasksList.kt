package com.example.mycurriculumvitae.model

import com.example.mycurriculumvitae.R

class ExperienceTasksList {
    fun loadExperienceTaskList(): List<ExperienceTaskList> {
        return listOf<ExperienceTaskList> (
            ExperienceTaskList(R.string.completion_of_tasks),
            ExperienceTaskList(R.string.test_driven_development),
            ExperienceTaskList(R.string.timely_submission),
            ExperienceTaskList(R.string.collaboration_on_tasks)
        )
    }
}
package com.example.mycurriculumvitae.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycurriculumvitae.R

@Composable
fun HomeScreen(navigateToEditScreen: () -> Unit ,modifier: Modifier = Modifier) {
    LazyColumn {
        items(1){
            ContactInfo()
            SummaryInfo()
            SkillHighlights()
            Experience()
            HobbiesSection()
            Button(onClick = { navigateToEditScreen }) {
                Text(text = "Edit")
            }
        }
    }
}

@Composable
fun ContactInfo(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.eliud_githuku),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .size(120.dp)
        )
        Spacer(modifier = Modifier.size(15.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(R.string.eliud_githuku),
                fontSize = 40.sp
            )
            Text(
                text = stringResource(R.string.phone_number),
                fontSize = 25.sp
            )
            Text(
                text = stringResource(R.string.user_email),
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun SummaryInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(4.dp)
    ){
        Text(
            text = stringResource(R.string.summary_title),
            fontSize = 20.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 5.dp)
        )
        Text(
            text = stringResource(R.string.summary_text),
            fontSize = 16.sp,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun SkillHighlights(modifier: Modifier = Modifier) {
    Column(

    ){
        Text(
            text = stringResource(R.string.skill_highlights),
            fontSize = 20.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 5.dp)
        )
        Text(
            text = stringResource(R.string.test_driven_development_skill),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(5.dp)
                .padding(start = 30.dp)
        )
        Text(
            text = stringResource(R.string.building_robust_apps),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(5.dp)
                .padding(start = 30.dp)
        )
        Text(
            text = stringResource(R.string.consuming_rest_apis),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(5.dp)
                .padding(start = 30.dp)
        )
        Text(
            text = stringResource(R.string.building_beautiful_uis),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(5.dp)
                .padding(start = 30.dp)
        )
        Text(
            text = stringResource(R.string.integrating_room_for_database),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(5.dp)
                .padding(start = 30.dp)
        )
        Text(
            text = stringResource(R.string.collaboration_with_team_members),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(5.dp)
                .padding(start = 30.dp)
        )
        Text(
            text = stringResource(R.string.eager_to_learn),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(5.dp)
                .padding(start = 30.dp)
        )
    }
}

@Composable
fun Experience() {
    Column {
        Text(
            text = stringResource(R.string.experience),
            fontSize = 20.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 5.dp)
        )
        Row {
            Text(
                text = stringResource(R.string.intern_mobile_developer),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = stringResource(R.string.hng_internship_duration),
                fontSize = 16.sp
            )
        }
        Row {
            Text(
                text = stringResource(R.string.hng_internship),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(2.dp)
            )
            Spacer(modifier = Modifier.size(3.dp))
            Text(
                text = stringResource(R.string.remote_based_internship),
                fontSize = 18.sp
            )
        }
        Text(
            text = stringResource(R.string.completion_of_tasks),
            fontSize = 15.sp,
            modifier = Modifier.padding(2.dp)
        )
        Text(
            text = stringResource(R.string.test_driven_development),
            fontSize = 15.sp,
            modifier = Modifier.padding(2.dp)
        )
        Text(
            text = stringResource(R.string.timely_submission),
            fontSize = 15.sp,
            modifier = Modifier.padding(2.dp)
        )
        Text(
            text = stringResource(R.string.collaboration_on_tasks),
            fontSize = 15.sp,
            modifier = Modifier.padding(2.dp)
        )
    }
}

@Composable
fun HobbiesSection() {
    Column {
        Text(
            text = stringResource(R.string.hobbies_title),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            modifier = Modifier.padding(5.dp)
        )
        Text(
            text = stringResource(R.string.reading_books),
            fontSize = 15.sp,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = stringResource(R.string.playing_field_hockey),
            fontSize = 15.sp,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = stringResource(R.string.attending_tech_meetups),
            fontSize = 15.sp,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navigateToEditScreen = {})
}
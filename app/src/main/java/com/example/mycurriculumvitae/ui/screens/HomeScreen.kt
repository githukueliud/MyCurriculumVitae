package com.example.mycurriculumvitae.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycurriculumvitae.R

@Composable
fun HomeScreen(
    onEditButtonClicked: () -> Unit,
    cvViewModel: CvViewModel,
    modifier: Modifier = Modifier
) {
    val cVUiState by cvViewModel.uiState.collectAsState()
    LazyColumn {
        items(1) {
            ContactInfo(
                currentName = cVUiState.currentName,
                currentGithubHandle = cVUiState.currentGithubHandle,
                currentPhoneNumber = cVUiState.currentPhoneNumber,
                currentSlackName = cVUiState.currentSlackName
            )
            SummaryInfo(
                currentSummaryText = cVUiState.currentSummaryText
            )
            SkillHighlights()
            Experience(
                currentInternshipDuration = cVUiState.currentInternshipDuration
            )
            HobbiesSection()


        }
    }


}

@Composable
fun ContactInfo(
    currentName: String,
    currentGithubHandle: String,
    currentPhoneNumber: String,
    currentSlackName: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .background(Color(147, 160, 39))
            .padding(5.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.eliud_githuku),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .size(140.dp)
        )
        Spacer(modifier = Modifier.size(15.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = currentName,
                fontSize = 30.sp
            )
            Row{
                Text(
                    text = currentSlackName,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = "(Slack)", fontSize = 20.sp)
            }
            Text(
                text = currentPhoneNumber,
                fontSize = 25.sp
            )
            Text(
                text = currentGithubHandle,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun SummaryInfo(
    currentSummaryText: String,
    modifier: Modifier = Modifier
) {
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
            text = currentSummaryText,
            fontSize = 16.sp,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun SkillHighlights(
    modifier: Modifier = Modifier
) {
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
    }
}

@Composable
fun Experience(
    currentInternshipDuration: String,
    modifier: Modifier = Modifier
) {
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
                modifier = Modifier.padding(start = 2.dp)
            )
            Text(
                text = currentInternshipDuration,
                fontSize = 18.sp,
                fontWeight = FontWeight(500)
            )
        }
        Row(
            modifier = Modifier.padding(bottom = 3.dp)
        ) {
            Text(
                text = stringResource(R.string.hng_internship),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 2.dp)
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
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = stringResource(R.string.test_driven_development),
            fontSize = 15.sp,
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = stringResource(R.string.timely_submission),
            fontSize = 15.sp,
            modifier = Modifier.padding(3.dp)
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
            modifier = Modifier.padding(4.dp)
        )

        Text(
            text = stringResource(R.string.playing_field_hockey),
            fontSize = 15.sp,
            modifier = Modifier.padding(2.dp)
        )
        Text(
            text = stringResource(R.string.attending_tech_meetups),
            fontSize = 15.sp,
            modifier = Modifier.padding(2.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        cvViewModel = viewModel(),
        onEditButtonClicked = {/* Do nothing */}
    )
}
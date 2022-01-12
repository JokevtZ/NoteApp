package nl.learningtocode.noteapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nl.learningtocode.noteapp.NoteButton
import nl.learningtocode.noteapp.NoteInputText
import nl.learningtocode.noteapp.R

@ExperimentalComposeUiApi
@Composable
fun NoteScreen(modifier : Modifier = Modifier){

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    Column(modifier = modifier
        .padding(6.dp))
    {
        TopAppBar(title =
        {
            Text(text = stringResource(id = R.string.app_name))
        },
        actions = {
            Icon(imageVector = Icons.Rounded.Notifications,
                contentDescription = "Icon")
        },
            backgroundColor = Color(0xFF570ADD)
        )

        // Content
        Column(modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally)
        {
        NoteInputText(
            modifier = modifier
                .padding(
                    top = 9.dp,
                    bottom = 8.dp
                ),
            text = title,
            label = "Title Note",
            onTextChanged = {
                if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) title = it
            })

            NoteInputText(
                modifier = modifier
                    .padding(
                        top = 9.dp,
                        bottom = 8.dp
                    ),
                text = description,
                label = "Add Note",
                onTextChanged = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) description = it
                })

            NoteButton(text = "Save Note",
                onClick = {})
        }
    }


}

@ExperimentalComposeUiApi
@Preview(showBackground = true )
@Composable
fun NoteScreenPreview(){
    NoteScreen()
}
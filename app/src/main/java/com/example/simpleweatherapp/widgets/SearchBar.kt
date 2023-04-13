package com.example.simpleweatherapp.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {}
) {

    Column {

        val searchQueryState = rememberSaveable {
            mutableStateOf("")
        }

        val keyBoardController = LocalSoftwareKeyboardController.current

        val valid = remember(searchQueryState.value) {
            searchQueryState.value.trim().isNotBlank()
        }

        CommonTextField(
            valueState = searchQueryState,
            placeHolder = "place name",
            onAction = KeyboardActions {

                if (!valid) {
                        return@KeyboardActions
                }

                onSearch(searchQueryState.value.trim())
                searchQueryState.value = ""
                keyBoardController?.hide()
            },
        )

    }


}

@Composable
fun CommonTextField(
    valueState: MutableState<String>,
    placeHolder: String,
    onAction: KeyboardActions = KeyboardActions.Default,
    keyBoardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next
) {

    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = { Text(text = placeHolder) },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyBoardType, imeAction = imeAction),
        keyboardActions = onAction,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue, cursorColor = Color.Black
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)

    )

}
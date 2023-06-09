package com.shankarlohar.pedopt_adoptapet.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A custom styled material search bar.
 * @param modifier the [Modifier] that will be applied to
 * the search bar.
 * @param value the input text to be shown in the searchBar.
 * @param label he label that is to be displayed inside the
 * searchBar.
 * @param onValueChange the callback that is triggered when the
 * an update to the text displayed in the searchBar is made. An
 * updated text comes as a parameter of the callback.
 */
@Composable
fun PedoptSearchBar(
    modifier: Modifier = Modifier,
    value: String,
    label: @Composable () -> Unit = {},
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier,
        leadingIcon = {
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = Icons.Filled.Search,
                contentDescription = "searchIcon"
            )
        },
        value = value,
        onValueChange = onValueChange,
        textStyle = MaterialTheme.typography.body1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.secondary,
            focusedLabelColor = MaterialTheme.colors.secondary
        ),
        label = label
    )

}
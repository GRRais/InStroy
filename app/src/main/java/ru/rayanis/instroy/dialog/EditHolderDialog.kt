package ru.rayanis.instroy.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.rayanis.instroy.ui.theme.DarkText

@Composable
fun EditHolderDialog(
    dialogController: EditHolderDialogController
) {
    if (dialogController.openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                dialogController.onEditHolderDialogEvent(EditHolderDialogEvent.OnCancel)
            },
            title = null,
            text = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = dialogController.dialogTitle.value,
                        style = TextStyle(
                            color = DarkText,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = dialogController.nameTextField.value,
                        onValueChange = {text ->
                            dialogController.onEditHolderDialogEvent(EditHolderDialogEvent.OnNameChange(text))
                        },
                        label = {
                            Text(text = "Ответственный")
                        },
                        singleLine = true
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    dialogController.onEditHolderDialogEvent(EditHolderDialogEvent.OnSave)
                }) {
                    Text(text = "Сохранить")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    dialogController.onEditHolderDialogEvent(EditHolderDialogEvent.OnCancel)
                }) {
                    Text(text = "Отмена")
                }
            }
        )
    }
}
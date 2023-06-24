package ru.rayanis.instroy.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.rayanis.instroy.ui.theme.DarkText

@Composable
fun DeleteDialog(
    dialogController: DeleteDialogController
) {
    if (dialogController.openDeleteDialog.value) {
        AlertDialog(
            onDismissRequest = {
                dialogController.onDeleteDialogEvent(DeleteDialogEvent.OnCancel)
            },
            title = null,
            text = {
                Column(modifier = Modifier
                    .fillMaxWidth()
                ) {
                    Text(
                        text = dialogController.dialogTitle.value,
                        style = TextStyle(
                            color = DarkText,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    dialogController.onDeleteDialogEvent(DeleteDialogEvent.OnConfirm)
                }) {
                    Text(text = "Да")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    dialogController.onDeleteDialogEvent(DeleteDialogEvent.OnCancel)
                }) {
                    Text(text = "Отмена")
                }
            }
        )
    }
}
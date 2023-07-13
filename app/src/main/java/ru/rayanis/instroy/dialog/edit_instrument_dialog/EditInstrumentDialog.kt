package ru.rayanis.instroy.dialog.edit_instrument_dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.rayanis.instroy.dialog.edit_instrument_amount_dialog.EditInstrumentAmountDialogController
import ru.rayanis.instroy.dialog.edit_instrument_amount_dialog.EditInstrumentAmountDialogEvent
import ru.rayanis.instroy.ui.theme.DarkText
import ru.rayanis.instroy.ui.theme.GrayLight

@Composable
fun EditInstrumentDialog(
    dialogController: EditInstrumentDialogController

) {
    if (dialogController.openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                dialogController.onEditInstrumentDialogEvent(EditInstrumentDialogEvent.OnCancel)
            },
            title = null,
            text = {
                Column(
                    modifier = Modifier
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
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = dialogController.instrumentNameText.value,
                        onValueChange = { text ->
                            dialogController.onEditInstrumentDialogEvent(
                                EditInstrumentDialogEvent.OnNameChange(
                                    text
                                )
                            )
                        },
                        modifier = Modifier.padding(top = 5.dp),
                        label = {
                            Text(text = "Наименование")
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = GrayLight,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(7.dp),
                        singleLine = true,
                        textStyle = TextStyle(
                            color = DarkText,
                            fontSize = 16.sp
                        )
                    )
                    TextField(
                        value = dialogController.additionalInfoText.value,
                        onValueChange = { text ->
                            dialogController.onEditInstrumentDialogEvent(
                                EditInstrumentDialogEvent.OnAdditionalInfoChange(
                                    text
                                )
                            )
                        },
                        modifier = Modifier.padding(top = 5.dp),
                        label = {
                            Text(text = "Дополнительная информация")
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = GrayLight,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(7.dp),
                        singleLine = true,
                        textStyle = TextStyle(
                            color = DarkText,
                            fontSize = 16.sp
                        )
                    )
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Доступно",
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                            Text(
                                text = dialogController.freeAmountText.value.toString(),
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                        }
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "На ремонте",
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                            Text(
                                text = dialogController.brokenAmountText.value.toString(),
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                        }
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Всего",
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                            Text(
                                text = dialogController.maxAmountText.value.toString(),
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                        }
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Списано",
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                            Text(
                                text = dialogController.decommissionAmountText.value.toString(),
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    dialogController.onEditInstrumentDialogEvent(EditInstrumentDialogEvent.OnSave)
                }) {
                    Text(text = "Сохранить")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    dialogController.onEditInstrumentDialogEvent(EditInstrumentDialogEvent.OnCancel)
                }) {
                    Text(text = "Отмена")
                }
            }
        )
    }
}
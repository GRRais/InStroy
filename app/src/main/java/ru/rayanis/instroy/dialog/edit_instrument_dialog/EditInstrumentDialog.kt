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
import ru.rayanis.instroy.dialog.edit_holder_dialog.EditHolderDialogEvent
import ru.rayanis.instroy.dialog.edit_instrument_amount_dialog.EditInstrumentAmountDialogController
import ru.rayanis.instroy.dialog.edit_instrument_amount_dialog.EditInstrumentAmountDialogEvent
import ru.rayanis.instroy.ui.theme.DarkText
import ru.rayanis.instroy.ui.theme.GrayLight

@Composable
fun EditInstrumentDialog(
    editInstrumentDialogController: EditInstrumentDialogController,
    editInstrumentAmountDialogController: EditInstrumentAmountDialogController

) {
    if (editInstrumentDialogController.openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                editInstrumentDialogController.onEditInstrumentDialogEvent(EditInstrumentDialogEvent.OnCancel)
            },
            title = null,
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = editInstrumentDialogController.dialogTitle.value,
                        style = TextStyle(
                            color = DarkText,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = editInstrumentDialogController.instrumentNameText.value,
                        onValueChange = { text ->
                            editInstrumentDialogController.onEditInstrumentDialogEvent(
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
                        value = editInstrumentDialogController.additionalInfoText.value,
                        onValueChange = { text ->
                            editInstrumentDialogController.onEditInstrumentDialogEvent(
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
                                text = editInstrumentDialogController.freeAmountText.value.toString(),
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
                                text = editInstrumentDialogController.brokenAmountText.value.toString(),
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
                                text = editInstrumentDialogController.maxAmountText.value.toString(),
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
                                text = editInstrumentDialogController.decommissionAmountText.value.toString(),
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
                    editInstrumentAmountDialogController.onChangeAmountDialogEvent(EditInstrumentAmountDialogEvent.OnSave)
                }) {
                    Text(text = "Сохранить")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    editInstrumentDialogController.onEditInstrumentDialogEvent(EditInstrumentDialogEvent.OnCancel)
                }) {
                    Text(text = "Отмена")
                }
            }
        )
    }
}
package ru.rayanis.instroy.dialog.edit_instrument_amount_dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.RadioButton
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
import ru.rayanis.instroy.ui.theme.DarkText
import ru.rayanis.instroy.ui.theme.GrayLight

@Composable
fun ChangeInstrumentAmountStatusDialog(
    dialogController: ChangeInstrumentAmountStatusDialogController
) {
    if (dialogController.openAmountDialog.value) {
        AlertDialog(
            onDismissRequest = {
                dialogController.onChangeInstrumentAmountStatusDialogEvent(
                    ChangeInstrumentAmountStatusDialogEvent.OnCancel
                )
            },
            title = null,
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = dialogController.amountDialogTitle.value,
                        style = TextStyle(
                            color = DarkText,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Количество",
                            modifier = Modifier.padding(top = 5.dp),
                            style = TextStyle(
                                color = DarkText,
                                fontSize = 16.sp
                            )
                        )
                        TextField(
                            value = dialogController.quantityText.value,
                            onValueChange = { text ->
                                dialogController.onChangeInstrumentAmountStatusDialogEvent(
                                    ChangeInstrumentAmountStatusDialogEvent.OnChangeInstrumentQuantity(
                                        text
                                    )
                                )
                            },
                            modifier = Modifier.padding(top = 5.dp),
                            label = {
                                Text(text = "0")
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
                    }
                    if (dialogController.showRadioButtons.value) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Количество",
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                            RadioButton(
                                selected = dialogController.freeAmountRadioButton.value,
                                onClick = { dialogController.freeAmountRadioButton.value })

                            TextField(
                                value = dialogController.quantityText.value,
                                onValueChange = { text ->
                                    dialogController.onChangeInstrumentAmountStatusDialogEvent(
                                        ChangeInstrumentAmountStatusDialogEvent.OnChangeInstrumentQuantity(
                                            text
                                        )
                                    )
                                },
                                modifier = Modifier.padding(top = 5.dp),
                                label = {
                                    Text(text = "0")
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
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    dialogController.onChangeInstrumentAmountStatusDialogEvent(
                        ChangeInstrumentAmountStatusDialogEvent.OnSave
                    )
                }) {
                    Text(text = "Да")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    dialogController.onChangeInstrumentAmountStatusDialogEvent(
                        ChangeInstrumentAmountStatusDialogEvent.OnCancel
                    )
                }) {
                    Text(text = "Отмена")
                }
            }
        )
    }
}
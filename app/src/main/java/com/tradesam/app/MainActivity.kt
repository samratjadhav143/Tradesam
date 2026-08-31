package com.tradesam.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TradeSamApp()
        }
    }
}

@Composable
fun TradeSamApp() {

    var signal by remember { mutableStateOf("WAIT") }
    var mode by remember { mutableStateOf("PAPER TRADING") }

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Top
        ) {

            Text(
                text = "TradeSam V1",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Dhan Trading Assistant",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "MARKET SIGNAL",
                        style = MaterialTheme.typography.labelLarge
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = signal,
                        style = MaterialTheme.typography.headlineLarge
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Waiting for confirmed setup"
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "INDICATORS",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text("EMA 9       —")
                    Text("EMA 15      —")
                    Text("VWAP        —")
                    Text("Breakout    —")
                    Text("Volume      —")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "TRADE PLAN",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text("Entry        —")
                    Text("Stop Loss    —")
                    Text("Target       —")
                    Text("Quantity     —")
                    Text("Risk         ₹1,000")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        signal = "BUY"
                    }
                ) {
                    Text("BUY")
                }

                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        signal = "SELL"
                    }
                ) {
                    Text("SELL")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    signal = "WAIT"
                }
            ) {
                Text("WAIT / RESET")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    mode = "PAPER TRADING"
                }
            ) {
                Text("PAPER TRADE")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "₹1,00,000 Capital"
            )

            Text(
                text = "Risk per trade: ₹1,000"
            )

            Text(
                text = "Mode: $mode"
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Real Dhan Orders: OFF"
            )
        }
    }
}

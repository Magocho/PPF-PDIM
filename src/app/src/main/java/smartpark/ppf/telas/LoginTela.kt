package smartpark.ppf.telas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.*
import androidx.compose.material3.SecureTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale

@Composable
fun LoginTela(loginCtrl: (String, String) -> Unit) {
  var pront by remember { mutableStateOf("") }
  val senha = rememberTextFieldState()

  Column(
    modifier = Modifier.fillMaxSize().padding(24.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {

    Image(
      painter = painterResource(id = R.drawable.img.logo),
      contentDescription = "PPF logo",
      modifier = Modifier.size(150.dp),
      contentScale = ContentScale.Fit
    )

    Text(
      text = "PPF - Pare Por Favor",
      style = MaterialTheme.typography.headlineLarge
    )

    Spacer(modifier = Modifier.height(40.dp))

    /* Pronturário input */
    OutlinedTextField(
      value = pront,
      onValueChange = { pront = it },
      label = { Text("Prontuário") },
      modifier = Modifier.fillMaxWidth(),
      singleLine = true,
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text
      )
    )

    Spacer(modifier = Modifier.height(16.dp))
            
    /* Pronturário input */
    SecureTextField(
      state = senha,
      label = { Text("Senha") },
      modifier = Modifier.fillMaxWidth(),
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Password
      )
    )

    Spacer(modifier = Modifier.height(24.dp))

    /* Botão */
    Button(
      onClick = { loginCtrl(pront, senha) },
      modifier = Modifier.fillMaxWidth()
    ) { Text("Login") }
  }
}

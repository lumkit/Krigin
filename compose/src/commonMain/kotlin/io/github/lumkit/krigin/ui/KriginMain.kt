package io.github.lumkit.krigin.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import io.github.lumkit.krigin.Const
import io.github.lumkit.krigin.common.preference.Preference
import io.github.lumkit.krigin.common.preference.preferencePlatform
import io.github.lumkit.krigin.mode.KriginThemeState
import io.github.lumkit.krigin.mode.KriginThemeStore
import io.github.lumkit.krigin.ui.theme.KriginTheme
import kotlinx.coroutines.launch

val LocalPreference = staticCompositionLocalOf<Preference> { error("No Preference Provided.") }
val LocalKriginThemeStore = staticCompositionLocalOf<KriginThemeStore> { error("No KriginThemeStore Provided.") }

@Composable
fun KriginMain() {
    val preference = remember { preferencePlatform("Krigin") }
    val kriginThemeStore = remember { KriginThemeStore() }

    LaunchedEffect(preference) {
        kriginThemeStore.appDarkTheme = try {
            KriginThemeState.entries[preference.getInt(Const.APP_THEME_STATE, 0)]
        }catch (_: Exception) {
            KriginThemeState.System
        }
    }

    LaunchedEffect(kriginThemeStore) {
        launch {
            snapshotFlow { kriginThemeStore.appDarkTheme }
                .collect {
                    preference.putInt(Const.APP_THEME_STATE, it.ordinal)
                }
        }
    }

    CompositionLocalProvider(
        LocalPreference provides preference,
        LocalKriginThemeStore provides kriginThemeStore,
    ) {
        KriginTheme {
            AppMain()
        }
    }
}

@Composable
fun AppMain() {
    val kriginThemeStore = LocalKriginThemeStore.current

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(it),
        ) {
            var expanded by remember { mutableStateOf(false) }

            Text(
                text = kriginThemeStore.appDarkTheme.name
            )

            Column {
                Button(
                    onClick = {
                        expanded = true
                    }
                ) {
                    Text(
                        text = "Expand",
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    KriginThemeState.entries.forEach {
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = it.name
                                )
                            },
                            onClick = {
                                kriginThemeStore.appDarkTheme = it
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
    }
}
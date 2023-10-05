package com.marcelo.pokemonmvi

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.Surface
import com.marcelo.pokemon.di.PokemonComponentProvider
import com.marcelo.pokemon.di.PokemonDependencies
import com.marcelo.pokemon.di.PokemonSubcomponent
import com.marcelo.pokemon.ui.navigation.PokemonNavGraph
import com.marcelo.pokemon.utils.InterceptorParams
import com.marcelo.pokemonmvi.di.DaggerMainComponent
import com.marcelo.pokemonmvi.di.MainComponent
import com.marcelo.pokemonmvi.ui.theme.PokemonMviTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview


@ExperimentalCoroutinesApi
@FlowPreview
@AndroidEntryPoint
@ExperimentalAnimationApi
class MainActivity : AppCompatActivity(), PokemonComponentProvider {

    private val mainComponent: MainComponent by lazy {
        initializeMainComponent()
    }

    private fun initializeMainComponent(): MainComponent {
        val component = (applicationContext as PokemonApp).appComponent
        return DaggerMainComponent.factory().create(component)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonMviTheme {
                Surface {
                    PokemonNavGraph(fragmentActivity = this)
                }
            }
        }
    }


    override fun providePokemonComponent(): PokemonSubcomponent = mainComponent
        .pokemonComponent()
        .create(
            pokemonDependencies = PokemonDependencies(
                interceptorParams = InterceptorParams(
                    tokenInterceptor = AnyInterceptor(),
                    unauthorizedInterceptor = AnyInterceptor()
                ),
                flavorName = "dummy",
                isDebug = true,
                context = this
            )
        )

}




package com.marcelo.pokemonmvi.di

import androidx.compose.animation.ExperimentalAnimationApi
import com.marcelo.pokemon.di.PokemonSubcomponent
import com.marcelo.pokemonmvi.MainActivity
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ActivityScope
@Component(
    modules = [SubcomponentsModule::class],
    dependencies = [AppComponent::class]
)
interface MainComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): MainComponent
    }

    fun pokemonComponent(): PokemonSubcomponent.Factory

    fun inject(activity: MainActivity)
}
package com.marcelo.pokemon.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marcelo.pokemon.presentation.DetailPokemonViewModel
import com.marcelo.pokemon.presentation.ListPokemonViewModel
import com.marcelo.pokemon.utils.ExecutionThread
import com.marcelo.pokemon.utils.ExecutionThreadImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview


@Module
@ExperimentalCoroutinesApi
@FlowPreview
@InstallIn(ViewModelComponent::class)
abstract class PresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListPokemonViewModel::class)
    abstract fun bindListViewModel(viewModel: ListPokemonViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailPokemonViewModel::class)
    abstract fun bindDetailViewModel(viewModel: DetailPokemonViewModel): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    companion object {

    }
}
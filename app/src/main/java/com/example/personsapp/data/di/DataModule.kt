package com.example.personsapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.personsapp.data.person.local.PersonDataBase
import com.example.personsapp.data.person.local.PersonRepository
import com.example.personsapp.data.person.local.datasource.PersonDatabaseDataSource
import com.example.personsapp.data.person.remote.network.PersonApiClient
import com.example.personsapp.domain.repository.IPersonRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    private const val PERSON_DATABASE_NAME = "person_database"

    @Provides
    @Singleton
    fun providePersonDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, PersonDataBase::class.java, PERSON_DATABASE_NAME)
            .build()

    @Provides
    @Singleton
    fun providePersonDao(db: PersonDataBase) = db.personDao()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePersonApiClient(retrofit: Retrofit): PersonApiClient{
        return retrofit.create(PersonApiClient::class.java)
    }

    @Provides
    fun providePersonRepository(
        personDatabaseDataSource: PersonDatabaseDataSource
    ): IPersonRepository{
        return PersonRepository(
             personDatabaseDataSource = personDatabaseDataSource
        )
    }

    @Provides
    fun providePersonDatabaseDataSource(
        personDataBase: PersonDataBase
    ): PersonDatabaseDataSource {
        return PersonDatabaseDataSource(
            personDataBase = personDataBase
        )
    }

}
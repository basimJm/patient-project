package come.basim.patient_android_project.data.di

import come.basim.patient_android_project.data.dataSource.PatientsDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    const val baseUrl = "https://patients-app-api.herokuapp.com/"

    @Provides
    @Singleton
    fun provideRetrofite(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


    @Provides
    @Singleton
    fun proviedPatientsDataSource(retrofit: Retrofit): PatientsDataSource {
        return retrofit.create(PatientsDataSource::class.java)
    }

    //@Provides
    //@Singleton
    //fun proviedRepositpory(dataSource: PatientsDataSource):PatientsReporsitory{
    //  return PatientsReporsitory(dataSource)
}


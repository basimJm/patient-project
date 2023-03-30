package come.basim.patient_android_project.data.di

import come.basim.patient_android_project.data.dataSource.PatientsDataSource
import come.basim.patient_android_project.data.repository.PatientsReporsitoryImpl
import come.basim.patient_android_project.domin.repo.PatientsReporsitory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideRepositoryPatients(patientsDataSource: PatientsDataSource): PatientsReporsitory {
        return PatientsReporsitoryImpl(patientsDataSource)
    }

}
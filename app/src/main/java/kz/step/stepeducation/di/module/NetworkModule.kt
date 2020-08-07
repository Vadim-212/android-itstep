package kz.step.stepeducation.di.module

import dagger.Module
import dagger.Provides
import kz.step.stepeducation.data.api.APIImplementation

@Module
class NetworkModule {
    @Provides
    fun providesApi() : APIImplementation {
        return APIImplementation()
    }
}
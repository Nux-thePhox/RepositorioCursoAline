import { ApplicationConfig, importProvidersFrom, provideBrowserGlobalErrorListeners, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideZoneChangeDetection({ eventCoalescing: true }),
    //Indicamos que somos un cliente http que consumira ws
    //FormsModule nos permite utilizar formularios con directivas bidireccionales ()
    provideRouter(routes), importProvidersFrom(ReactiveFormsModule, FormsModule),
    provideHttpClient(withInterceptorsFromDi())
  ]
};

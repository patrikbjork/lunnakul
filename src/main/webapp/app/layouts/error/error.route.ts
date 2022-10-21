import { Routes } from '@angular/router';

import { ErrorComponent } from './error.component';

export const errorRoute: Routes = [
  {
    path: 'error',
    component: ErrorComponent,
    data: {
      pageTitle: 'Felsida!',
    },
  },
  {
    path: 'accessdenied',
    component: ErrorComponent,
    data: {
      pageTitle: 'Felsida!',
      errorMessage: 'Du har inte behörighet till att komma åt sidan.',
    },
  },
  {
    path: '404',
    component: ErrorComponent,
    data: {
      pageTitle: 'Felsida!',
      errorMessage: 'Sidan existerar inte.',
    },
  },
  {
    path: '**',
    redirectTo: '/404',
  },
];

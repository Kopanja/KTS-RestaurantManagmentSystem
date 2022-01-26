import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreatorToolComponent } from './creator-tool/creator-tool.component';
import { RestaurantFloorComponent } from './restaurant-floor/restaurant-floor.component';
import { WaiterPageComponent } from './waiter-page/waiter-page.component';
import { BartenderPageComponent } from './bartender-page/bartender-page.component';
import { CookPageComponent } from './cook-page/cook-page.component';
import { ManagerPageComponent } from './manager-page/manager-page.component';
import { LoginUsrnPassComponent } from './login-usrn-pass/login-usrn-pass.component';
import { LoginPinComponent } from './login-pin/login-pin.component';
import { CanActivateAuthGuard } from './services/can-activate-auth.guard';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {
    path: 'waiter', component: WaiterPageComponent,
    canActivate: [CanActivateAuthGuard],
    data: {
      roles: ['ADMIN', 'MENAGER','WAITER']
    }
  },
  {
    path: 'create-layout', component: CreatorToolComponent,
    data: {
      roles: ['ADMIN']
    }
  },
  {
    path: 'bartender', component: BartenderPageComponent,
    canActivate: [CanActivateAuthGuard],
    data: {
      roles: ['ADMIN', 'MENAGER','BARTENDER']
    }
  },
  {
    path: 'menager', component: ManagerPageComponent,
    canActivate: [CanActivateAuthGuard],
    data: {
      roles: ['ADMIN', 'MENAGER']
    }
  },
  {
    path: 'admin', component: AdminPageComponent,
    canActivate: [CanActivateAuthGuard],
    data: {
      roles: ['ADMIN', 'ADMIN']
    }
  },
  {
    path : 'cook', component: CookPageComponent,
    data: {
      roles: ['ADMIN', 'MENAGER','COOK']
    }
  },
  {path: 'usr-pass-login', component: LoginUsrnPassComponent},
  {path: 'pin-login', component: LoginPinComponent},
  {path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

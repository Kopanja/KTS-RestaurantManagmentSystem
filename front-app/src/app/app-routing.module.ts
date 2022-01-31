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
import { UserComponent } from './user/user.component';
import { NewUserFormComponent } from './new-user-form/new-user-form.component';
import { ItemPageComponent } from './item-page/item-page.component';
import { ItemDetailsComponent } from './item-details/item-details.component';

const routes: Routes = [
  {
    path: 'waiter', component: WaiterPageComponent,
    canActivate: [CanActivateAuthGuard],
    data: {
      roles: ['ADMIN', 'MANAGER','WAITER']
    }
  },
  {
    path: 'items', component: ItemPageComponent,
    canActivate: [CanActivateAuthGuard],
    data: {
      roles: ['ADMIN', 'MANAGER']
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
      roles: ['ADMIN', 'MANAGER','BARTENDER']
    }
  },
  {
    path: 'menager', component: ManagerPageComponent,
    canActivate: [CanActivateAuthGuard],
    data: {
      roles: ['ADMIN', 'MANAGER']
    }
  },
  {
    path: 'new-user', component: NewUserFormComponent,
    canActivate: [CanActivateAuthGuard],
    data: {
      roles: ['ADMIN']
    }
  },
  {
    path: 'user/:id', component: UserComponent,
    canActivate: [CanActivateAuthGuard],
    data: {
      roles: ['ADMIN', 'MANAGER']
    }
  },
  {
    path: 'item-details/:name', component: ItemDetailsComponent,
    canActivate: [CanActivateAuthGuard],
    data: {
      roles: ['ADMIN', 'MANAGER']
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
      roles: ['ADMIN','MANAGER','COOK']
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

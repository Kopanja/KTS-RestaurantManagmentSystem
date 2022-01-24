import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreatorToolComponent } from './creator-tool/creator-tool.component';
import { RestaurantFloorComponent } from './restaurant-floor/restaurant-floor.component';
import { WaiterPageComponent } from './waiter-page/waiter-page.component';
import { BartenderPageComponent } from './bartender-page/bartender-page.component';
import { CookPageComponent } from './cook-page/cook-page.component';
import { ManagerPageComponent } from './manager-page/manager-page.component';
import { LoginUsrnPassComponent } from './login-usrn-pass/login-usrn-pass.component';

const routes: Routes = [
  {path: 'floor-layout', component: WaiterPageComponent},
  {path: 'create-layout', component: CreatorToolComponent},
  {path: 'bartender', component: BartenderPageComponent},
  {path: 'manager', component: ManagerPageComponent},
  {path : 'cook', component: CookPageComponent},
  {path: 'usr-pass-login', component: LoginUsrnPassComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

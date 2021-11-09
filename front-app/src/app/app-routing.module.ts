import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreatorToolComponent } from './creator-tool/creator-tool.component';
import { RestaurantFloorComponent } from './restaurant-floor/restaurant-floor.component';
import { WaiterPageComponent } from './waiter-page/waiter-page.component';
const routes: Routes = [
  {path: 'floor-layout', component: WaiterPageComponent},
  {path: 'create-layout', component: CreatorToolComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SittingTableComponent } from './sitting-table/sitting-table.component';
import { RestaurantFloorComponent } from './restaurant-floor/restaurant-floor.component';
const routes: Routes = [
  {path: 'floor-layout', component: SittingTableComponent},
  {path: 'create-layout', component: RestaurantFloorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

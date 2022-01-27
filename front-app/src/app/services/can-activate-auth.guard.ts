import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class CanActivateAuthGuard implements CanActivate {

  constructor(private authenticationService: AuthenticationService, private router: Router) { }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      
      let url: string = state.url;
      return this.checkUserLogin(route, url);
  }

  checkUserLogin(route: ActivatedRouteSnapshot, url: any): boolean {
    
    if (this.authenticationService.isLoggedIn()) {
      const userRole = this.authenticationService.getLoggedInUserRole();
      //console.log(userRole);
      if (route.data.roles && route.data.roles.indexOf(userRole.authority) === -1) {
        this.router.navigate(['']);
        return false;
      }
      return true;
    }

    this.router.navigate(['']);
    return false;
  }
  
}

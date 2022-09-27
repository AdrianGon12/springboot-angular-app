import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Product } from '../common/product';
import { ProductCategory } from '../common/product-category';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private baseUrl = 'http://localhost:8080/api/products';
  private categoryUrl = 'http://localhost:8080/api/categories';

  constructor(private http: HttpClient) {}

  getProductListPaginate(
    thePage: number,
    thePageSize: number,
    theCategoryId: number
  ): Observable<GetResponse> {
    const searchUrl =
      `${this.baseUrl}/category/${theCategoryId}` +
      `?page=${thePage}&size=${thePageSize}`;

    return this.http.get<GetResponse>(searchUrl);
  }

  getProductList(theCategoryId: number): Observable<Product[]> {
    const searchUrl = `${this.baseUrl}/category/${theCategoryId}`;

    return this.http
      .get<GetResponse>(searchUrl)
      .pipe(map((response) => response.content));
  }

  getProductCategories(): Observable<ProductCategory[]> {
    return this.http.get<ProductCategory[]>(this.categoryUrl);
  }

  searchProducts(theKeyword: string) {
    const searchUrl = `${this.baseUrl}/search/${theKeyword}`;

    return this.http
      .get<GetResponse>(searchUrl)
      .pipe(map((response) => response.content));
  }

  searchProductsPaginate(
    thePage: number,
    thePageSize: number,
    theKeyword: string
  ): Observable<GetResponse> {
    const searchUrl =
      `${this.baseUrl}/search/${theKeyword}` +
      `?page=${thePage}&size=${thePageSize}`;

    return this.http.get<GetResponse>(searchUrl);
  }

  getProduct(theProductId: number): Observable<Product> {
    const productUrl = `${this.baseUrl}/${theProductId}`;
    return this.http.get<Product>(productUrl);
  }
}

interface GetResponse {
  content: [];
  size: number;
  totalElements: number;
  totalPages: number;
  number: number;
}

import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './index.css';
import Header from './pages/Header.tsx';
import ProductList from './pages/ProductList.tsx';
import Products from './pages/Products.tsx';
import NoPage from './pages/NoPage.tsx';

const appBase = (
<React.StrictMode>
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Header />}>
        <Route index element={<ProductList />} />
        <Route path="products/:id" element={<Products />} />
        <Route path="*" element={<NoPage />} />
      </Route>
    </Routes>
  </BrowserRouter>
</React.StrictMode>
);

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(appBase);

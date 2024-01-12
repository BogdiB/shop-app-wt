import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './index.css';
import Header from './pages/Header.tsx';
import ItemList from './pages/ItemList.tsx';
import Product from './pages/Product.tsx';
import NoPage from './pages/NoPage.tsx';

const appBase = (
<React.StrictMode>
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Header />}>
        <Route index element={<ItemList />} />
        <Route path="/product/:id" element={<Product />} />
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

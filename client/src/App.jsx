import { useMemo, useState } from 'react'
import { BrowserRouter, Navigate, Routes, Route } from 'react-router-dom'
import HomePage from './page/homePage';
import LoginPage from './page/loginPage';
import ProfilePage from './page/profilePage';
import { useSelector } from 'react-redux';
import { CssBaseline, ThemeProvider } from '@mui/material';
import { createTheme } from '@mui/material/styles';
import { themeSettings } from './theme';

function App() {
  
  const mode = useSelector((state)=> state.mode);
  const theme = useMemo(() => createTheme(themeSettings(mode)), [mode]);

  return (
    <div className="App">
      <BrowserRouter>
        <ThemeProvider theme={theme}>
          <CssBaseline />
          <Routes>
            <Route path='/' element={<LoginPage />}/>
            <Route path='/home' element={<HomePage />}/>
            <Route path='/profile/:userId' element={<ProfilePage />}/>
          </Routes>
        </ThemeProvider>
      </BrowserRouter>
     
    </div>
  )
}

export default App

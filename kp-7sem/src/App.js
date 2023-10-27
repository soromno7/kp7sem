import LoginPage from "./pages/login/LoginPage";
// import { MuiThemeProvider, createMuiTheme } from 'material-ui/styles';

// const { palette } = createTheme();
// const { augmentColor } = palette;
// const createColor = (mainColor) => augmentColor({ color: { main: mainColor } });
// const theme = createTheme({
//   palette: {
//     button: createColor('#F40B27'),
//     input: createColor('#5DBA40'),
//   },
// });

function App() {
  return (
    <div className="App">
    {/* <MuiThemeProvider theme={theme}> */}
    {/* </MuiThemeProvider> */}
    <LoginPage />
    </div>
  );
}

export default App;

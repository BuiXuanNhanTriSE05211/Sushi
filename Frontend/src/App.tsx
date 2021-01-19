/* eslint-disable prefer-destructuring */
import React, { 
  ChangeEvent
  , FormEvent
  , MouseEvent
  , ReactElement
  , useState 
} from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import { User } from './model/User';
import { UserAPI } from './common/service/UserAPI';

function App (): ReactElement {
  let [user, setUser] = useState<User> (new User ());
  let updatedUser: User | undefined;
  let inputField: HTMLInputElement | HTMLTextAreaElement | undefined;
  let userAPI: UserAPI | undefined;
  let userID: string;

  function updateUser (
    event: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ): User {
    inputField = event.target;
    updatedUser = user;
    updatedUser[inputField.name as keyof User] = inputField.value;
    return updatedUser;
  }
  
  function signUp (event: FormEvent<HTMLFormElement>){
    event.preventDefault ();
    userAPI = new UserAPI ();
    userAPI.registerUser (user);  
  }

  /**/
  function deleteUser (event: MouseEvent<HTMLButtonElement>){
    event.preventDefault ();
    userAPI = new UserAPI ();
    userID = user.userID;
    userAPI.deleteUser (userID);
  }
  /**/

  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <div>
        <Avatar>
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Sign up
        </Typography>
        <form 
          noValidate 
          onSubmit = {(event) => {
              signUp (event);
        }}>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                autoComplete="userID"
                name="userID"
                variant="outlined"
                required
                fullWidth
                id="userID"
                label="User ID"
                // value = {user.userID}
                autoFocus
                onChange = {(event) => {
                  setUser (updateUser (event));
                }}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                name="userName"
                label="User Name"
                type="text"
                id="userName"
                autoComplete="User-name"
                onChange = {(event) => {
                  setUser (updateUser (event));
                }}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="userEmail"
                label="userEmail Address"
                name="userEmail"
                autoComplete="Email-address"
                onChange = {(event) => {
                  setUser (updateUser (event));
                }}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="userPhone"
                label="Phone"
                name="userPhone"
                autoComplete="Phone"
                onChange = {(event) => {
                  setUser (updateUser (event));
                }}
              />
            </Grid>
            <Grid item xs={12}>
            </Grid>
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
          >
            Sign Up
          </Button>
          <Grid container justify="flex-end">
            <Grid item>
              <Link href="#" variant="body2">
                Already have an account? Sign in
              </Link>
            </Grid>
          </Grid>
        </form>
        <form>
        <button 
          type = "button"
          onClick = {(event) => {
            deleteUser (event);
          }}
        >
          Delete user.
        </button>
        </form>
      </div>
    </Container>
  );
}

export default App;

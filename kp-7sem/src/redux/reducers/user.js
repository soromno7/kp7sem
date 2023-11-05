const ADD_USER = 'ADD_USER';

const initialState = {
    email: '',
    password: '',
    phone: '',
    date_of_birth: '',
    first_name: '',
    last_name: '',
    role: '',
    status: ''
}

const user = (state = initialState, action) => {
  switch (action.type) {
      case ADD_USER:
          return {
              ...state,
              email: action.payload.email,
              password: action.payload.password,
              phone: action.payload.phone,
              date_of_birth: action.payload.date_of_birth,
              first_name: action.payload.first_name,
              last_name: action.payload.last_name,
              role: action.payload.role,
              status: action.payload.status
          };
      default:
      return state;
  }
};

export default user;
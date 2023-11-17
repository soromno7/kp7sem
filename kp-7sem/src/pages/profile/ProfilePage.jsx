function ProfilePage() {
    const userData = sessionStorage.user;
    return (
        <div>
            <span>Почта: </span>
            <span>{JSON.parse(userData).email}</span>
        </div>
    );
}

export default ProfilePage;
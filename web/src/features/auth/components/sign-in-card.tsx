import {Card, CardContent, CardHeader, CardTitle} from "@/components/ui/card";
import {DottedSeparator} from "@/components/dotted-separator";
import {Input} from "@/components/ui/input";
import {Button} from "@/components/ui/button";
import {FcGoogle} from "react-icons/fc";
import {FaGithub} from "react-icons/fa";
import Link from "next/link";

export const SignInCard = () => {
    return (
        <Card className={"w-full h-full md:w-[487px] border-none shadow-none"}>
            <CardHeader className={"flex items-center justify-center text-center p-7"}>
                <CardTitle className={"text-2xl"}>
                    Welcome Back!
                </CardTitle>
            </CardHeader>
            <div className={"px-7"}>
                <DottedSeparator/>
            </div>
            <CardContent className={"p-7"}>
                <form className={"space-y-4"}>
                    <Input
                        required
                        type={"email"}
                        value={""}
                        onChange={() => {
                        }}
                        placeholder={"Enter email address"}
                        disabled={false}
                    >
                    </Input>

                    <Input
                        required
                        type={"password"}
                        value={""}
                        onChange={() => {
                        }}
                        placeholder={"Enter password"}
                        disabled={false}
                        min={8}
                        max={256}
                    >
                    </Input>
                    <Button disabled={false} size={"lg"} className={"w-full"} type="submit">
                        Login
                    </Button>
                </form>
            </CardContent>
            <div className={"px-7"}>
                <DottedSeparator/>
            </div>
            <CardContent className={"p-7 flex flex-col gap-y-4"}>
                <Button
                    disabled={false}
                    variant={"secondary"}
                    size={"lg"}
                    className={"w-full"}
                >
                    <FcGoogle className={"mr-2 size-5"}/>
                    Login with Google
                </Button>
                <Button
                    disabled={false}
                    variant={"secondary"}
                    size={"lg"}
                    className={"w-full"}
                >
                    <FaGithub className={"mr-2 size-5"}/>
                    Login with Github
                </Button>
                <div className={"px-7"}>
                    <DottedSeparator/>
                </div>
                <CardContent className={"p-7 flex items-center justify-center"}>
                    <p>
                        Don&apos;t have an account?
                        <Link href={"/sign-up"}>
                            <span className={"text-blue-700"}>&nbsp;Sign Up</span>
                        </Link>
                    </p>
                </CardContent>
            </CardContent>
        </Card>
    )
}